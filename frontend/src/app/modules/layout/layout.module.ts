import {NgModule} from "@angular/core";
import {PersonalAccountComponent} from "./components/personalAccount/personal-account/personal-account.component";
import {LoginComponent} from "./components/main/login/login.component";
import {ServicesComponent} from "./components/main/services/services.component";
import {TopComponent} from "./components/main/top/top.component";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {MainPageComponent} from "./components/main/main-page/main-page.component";
import {Faq} from "../models/faq";
import {HeaderMainComponent} from "./components/main/header-main/header-main.component";
import {RegisterComponent} from "./components/main/register/register.component";
import {HeaderComponent} from "./components/personalAccount/header/header.component";
import {PersonalDataComponent} from "./components/personalAccount/personal-data/personal-data.component";
import {SecurityComponent} from "./components/personalAccount/security/security.component";
import {WalletComponent} from "./components/personalAccount/wallet/wallet.component";
import {FaqComponent} from "./components/main/faq/faq.component";
import {ConnectedService} from "../models/connectedService";
import {ConnectedServicesComponent} from "./components/personalAccount/connected-services/connected-services.component";
import {HttpClientModule} from "@angular/common/http";
import {BrowserModule} from "@angular/platform-browser";
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [
    ConnectedServicesComponent,
    PersonalAccountComponent,
    ServicesComponent,
    TopComponent,
    LoginComponent,
    FaqComponent,
    HeaderMainComponent,
    LoginComponent,
    MainPageComponent,
    RegisterComponent,
    ServicesComponent,
    TopComponent,
    HeaderComponent,
    PersonalDataComponent,
    SecurityComponent,
    WalletComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    CommonModule,
    FormsModule
  ],
  providers: [],
  exports: [PersonalAccountComponent, MainPageComponent]
})
export class LayoutModule {

}
