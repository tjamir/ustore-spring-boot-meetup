import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableFoldersComponent } from './table-folders.component';

describe('TableFoldersComponent', () => {
  let component: TableFoldersComponent;
  let fixture: ComponentFixture<TableFoldersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableFoldersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableFoldersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
