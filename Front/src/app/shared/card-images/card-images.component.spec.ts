import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardImagesComponent } from './card-images.component';

describe('CardImagesComponent', () => {
  let component: CardImagesComponent;
  let fixture: ComponentFixture<CardImagesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CardImagesComponent]
    });
    fixture = TestBed.createComponent(CardImagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
