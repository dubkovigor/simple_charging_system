import {NgModule} from "@angular/core";
import {PersonalAccountComponent} from "./components/personalAccount/personal-account/personal-account.component";
import {LoginComponent} from "./components/main/login/login.component";
import {ServicesComponent} from "./components/main/services/services.component";
import {TopComponent} from "./components/main/top/top.component";
import {FormsModule} from "@angular/forms";
import {MainPageComponent} from "./components/main/main-page/main-page.component";
import {HeaderMainComponent} from "./components/main/header-main/header-main.component";
import {RegisterComponent} from "./components/main/register/register.component";
import {HeaderComponent} from "./components/personalAccount/header/header.component";
import {PersonalDataComponent} from "./components/personalAccount/personal-data/personal-data.component";
import {SecurityComponent} from "./components/personalAccount/security/security.component";
import {WalletComponent} from "./components/personalAccount/wallet/wallet.component";
import {FaqComponent} from "./components/main/faq/faq.component";
import {ConnectedServicesComponent} from "./components/personalAccount/connected-services/connected-services.component";
import {HttpClientModule} from "@angular/common/http";
import {BrowserModule} from "@angular/platform-browser";
import {CommonModule} from "@angular/common";
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { UserComponent } from './components/admin-page/user/user.component';
import { BillingAccountComponent } from './components/admin-page/user/billing-account/billing-account.component';
import { ServiceComponent } from './components/admin-page/user/service/service.component';
import { HeaderAdminComponent } from './components/admin-page/header-admin/header-admin.component';
import {HttpService} from "../../services/http.service";

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
    WalletComponent,
    AdminPageComponent,
    UserComponent,
    BillingAccountComponent,
    ServiceComponent,
    HeaderAdminComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    CommonModule,
    FormsModule
  ],
  providers: [HttpService],
  exports: [PersonalAccountComponent, MainPageComponent, AdminPageComponent]
})
export class LayoutModule {

}
