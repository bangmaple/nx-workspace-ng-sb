import { Component } from '@angular/core';
import {PrimeNGConfig} from "primeng/api";
import {Router} from "@angular/router";

@Component({
  selector: 'bangmaple-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'lms';

  constructor(private readonly primengConfig: PrimeNGConfig,
              private readonly router: Router) {
    this.style = {
      'height': '500px',
      'display': 'grid',
      'place-items': 'center'
    };
    this.primengConfig.ripple = true;
  }


  style: any;


  ngOnInit(): void {
    console.log('');
  }

}
