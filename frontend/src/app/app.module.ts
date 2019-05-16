import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { PersonalAccountComponent } from './modules/layout/components/personalAccount/personal-account/personal-account.component';
import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './modules/layout/components/main/login/login.component';
import { MainPageComponent } from './modules/layout/components/main/main-page/main-page.component';
import { RegisterComponent } from './modules/layout/components/main/register/register.component';
import {LayoutModule} from "./modules/layout/layout.module";
import {HttpService} from "./services/http.service";
import {HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";
import {AdminPageComponent} from "./modules/layout/components/admin-page/admin-page.component";

const routes: Routes = [
  {path: '' , redirectTo: 'main', pathMatch: 'full'},
  {path: 'personal-account', component: PersonalAccountComponent},
  {path: 'login', component: LoginComponent},
  {path: 'main', component: MainPageComponent},
  {path: 'register', component: RegisterComponent },
  // {path: 'adminpage', component: AdminPageComponent}
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    CommonModule,
    FormsModule,
    RouterModule.forRoot(routes),
    LayoutModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
