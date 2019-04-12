import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectedServicesComponent } from './connected-services.component';

describe('ConnectedServicesComponent', () => {
  let component: ConnectedServicesComponent;
  let fixture: ComponentFixture<ConnectedServicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectedServicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectedServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
