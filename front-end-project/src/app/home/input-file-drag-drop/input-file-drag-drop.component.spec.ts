import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputFileDragDropComponent } from './input-file-drag-drop.component';

describe('InputFileDragDropComponent', () => {
  let component: InputFileDragDropComponent;
  let fixture: ComponentFixture<InputFileDragDropComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputFileDragDropComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputFileDragDropComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
