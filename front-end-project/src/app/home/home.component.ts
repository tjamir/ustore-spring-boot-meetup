import { Component, AfterViewInit, Input } from '@angular/core';

import * as Prism from 'prismjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit {

  data : any[] = [
    {
      id: '3123123123',
      size: '9200',
      userid: 4124,
      archives: [
        {
          name: 'josine.png',
          hash: '9UJ2OIDJASIDJSADASD',
          status: 'completed',
          last_modified: new Date()
        }, 
        {
          name: 'document.png',
          hash: '3123123123',
          status: 'completed',
          last_modified: new Date()
        }
      ],

    },    
  ];

  /**
   * @method ngAfterViewInit
   */
  ngAfterViewInit() {
    Prism.highlightAll();
  }
}
