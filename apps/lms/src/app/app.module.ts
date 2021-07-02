import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NotFoundComponent } from './core/not-found/not-found.component';
import {RouterModule} from "@angular/router";
import {DividerModule} from "primeng/divider";
import {CardModule} from "primeng/card";
import {AppRoutingModule} from "./app-routing.module";
import {DialogModule} from "primeng/dialog";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [AppComponent, NotFoundComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule,
    DividerModule,
    CardModule,
    AppRoutingModule, DialogModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
