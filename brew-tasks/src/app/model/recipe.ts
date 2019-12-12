import {Lager} from './lager';
import {AllGrain} from './allGrain';
import {RecipeName} from './recipeName';

export class Recipe {
  id: string;
  lager: Lager;
  allGrain: AllGrain;
  recipeName: RecipeName;
}
