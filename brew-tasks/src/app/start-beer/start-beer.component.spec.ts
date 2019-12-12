import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartBeerComponent } from './start-beer.component';

describe('StartBeerComponent', () => {
  let component: StartBeerComponent;
  let fixture: ComponentFixture<StartBeerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartBeerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartBeerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
