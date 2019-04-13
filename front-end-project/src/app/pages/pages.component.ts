import { Component } from '@angular/core';


@Component({
  selector: 'ngx-pages',
  template: `
    <ngx-one-column-layout>    
      <router-outlet></router-outlet>
    </ngx-one-column-layout>
  `,
})
export class PagesComponent {

    
}
