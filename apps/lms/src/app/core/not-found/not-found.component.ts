import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'bangmaple-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.scss']
})
export class NotFoundComponent implements OnInit {

  style: any;

  constructor() {
    this.style = {
      'height': '100vh',
      'display': 'grid',
      'place-items': 'center'
    };
  }

  ngOnInit(): void {
    console.log('');
  }

}
