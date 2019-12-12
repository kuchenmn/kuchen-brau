package org.camunda.bpm.edtrail.kuchenbrau.simulator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootApplication
public class SimulatorApplication {

	public static String GET_TASK_LIST = "http://localhost:8080/rest/task";
	public static String CLAIM_TASK = "http://localhost:8080/rest/task/%s/claim";
	public static String COMPLETE_TASK = "http://localhost:8080/rest/task/%s/complete";
	public static String START_PROCESS = "http://localhost:8080/rest/process-definition/key/brew_process/start";

	public static final String[] recipes = {
			"Kuchen Lager",
			"Kuchen Ale",
			"Kuchen Weisse",
			"Kuchen Pils",
			"Kuchen IPA"
	};

	private static final Logger log = LoggerFactory.getLogger(SimulatorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimulatorApplication.class, args).close();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			// start a bunch of instances
			startProcesses(restTemplate);

			// let the engine catch up
			log.info("waiting for 5 seconds for the engine to catch up");
			Thread.sleep(5000);

			// get the tasks to complete
			List<String> ids = getClaimableTasks(restTemplate);

			// claim the tasks
			claimTasks(restTemplate, ids);

			// complete the tasks with different variables
			completeTasks(restTemplate, ids);
		};
	}

	private void startProcesses(RestTemplate restTemplate) {
		int processesStarted = 0;
		for (int i = 0; i < 20; i++) {
			JSONObject businessKey = new JSONObject();
			businessKey.put("businessKey", UUID.randomUUID());
			HttpEntity<String> request = new HttpEntity<>(businessKey.toString(), getHttpHeaders());
			ResponseEntity<String> claimResponse = restTemplate.postForEntity(START_PROCESS, request, String.class);
			HttpStatus statusCode = claimResponse.getStatusCode();
			processesStarted++;
			if (statusCode != HttpStatus.OK) {
				log.error("Claim task returned " + statusCode + " but should have returned 200");
				processesStarted--;
			}
		}

		log.info("Started " + processesStarted + " process instances");
	}

	private List<String> getClaimableTasks(RestTemplate restTemplate) {
		List<String> ids = new ArrayList<>();
		String json = restTemplate.getForObject(GET_TASK_LIST, String.class);
		JSONArray jsonArray = new JSONArray(json);
		for (int i = 0; i < jsonArray.length(); i++) {
			String id = jsonArray.getJSONObject(i).getString("id");
			ids.add(id);
		}
		return ids;
	}

	private void claimTasks(RestTemplate restTemplate, List<String> ids) {
		int processesClaimed = 0;
		for (String id: ids) {
			JSONObject userId = new JSONObject();
			userId.put("userId", "demo");
			HttpEntity<String> request = new HttpEntity<>(userId.toString(), getHttpHeaders());
			ResponseEntity<Object[]> claimResponse = restTemplate.postForEntity(String.format(CLAIM_TASK, id), request, Object[].class);
			HttpStatus statusCode = claimResponse.getStatusCode();
			processesClaimed++;
			if (statusCode != HttpStatus.NO_CONTENT) {
				log.error("Claim task returned " + statusCode + " but should have returned 204");
				processesClaimed--;
			}
		}
		log.info("Claimed " + processesClaimed + " process instances");
	}

	private void completeTasks(RestTemplate restTemplate, List<String> ids) {
		int processesCompleted = 0;
		for (String id: ids) {
			HttpEntity<String> request = new HttpEntity<>(getRandomVarirables().toString(), getHttpHeaders());
			ResponseEntity<Object[]> completeResponse = restTemplate.postForEntity(String.format(COMPLETE_TASK, id), request, Object[].class);
			HttpStatus statusCode = completeResponse.getStatusCode();
			processesCompleted++;
			if (statusCode != HttpStatus.NO_CONTENT) {
				log.error("Complete task returned " + statusCode + " but should have returned 204");
				processesCompleted--;
			}
		}

		log.info("Completed " + processesCompleted + " process instances");
	}

	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	private JSONObject getRandomVarirables() {
		Random random = new Random();
		String randomRecipe = recipes[random.nextInt(recipes.length)];
		JSONObject variables = new JSONObject();
		JSONObject lager = new JSONObject();
		lager.put("value", random.nextBoolean());
		variables.put("lager", lager);
		JSONObject allGrain = new JSONObject();
		allGrain.put("value", random.nextBoolean());
		variables.put("allGrain", allGrain);
		JSONObject recipe = new JSONObject();
		recipe.put("value", randomRecipe);
		variables.put("recipeName", recipe);

		JSONObject vars = new JSONObject();
		vars.put("variables", variables);
		return vars;
	}

}
