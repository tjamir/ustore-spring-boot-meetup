import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-table-folders',
  templateUrl: './table-folders.component.html',
  styleUrls: ['./table-folders.component.css']
})
export class TableFoldersComponent implements OnInit {

    @Input() data : any;

  dataFiles : any[] = [];
  // selfUserid : any = 4124;

  constructor() { }

  ngOnInit() {
    this.dataFiles = this.data[0].archives;
    console.log(this.dataFiles);      
    }
   
    
  }

