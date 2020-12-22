import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { PersonalAccountComponent } from './modules/layout/components/personalAccount/personal-account/personal-account.component';
import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './modules/layout/components/main/login/login.component';
import { MainPageComponent } from './modules/layout/components/main/main-page/main-page.component';
import { RegisterComponent } from './modules/layout/components/main/register/register.component';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
// import {LayoutModule} from './modules/layout/layout.module';
import {AdminPageComponent} from './modules/layout/components/admin-page/admin-page.component';
import {BsDropdownModule, ModalModule, TooltipModule} from 'ngx-bootstrap';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
import {BillingAccountComponent} from './modules/layout/components/admin-page/user/billing-account/billing-account.component';
import {FaqComponent} from './modules/layout/components/main/faq/faq.component';
import {HeaderMainComponent} from './modules/layout/components/main/header-main/header-main.component';
import {ServicesComponent} from './modules/layout/components/main/services/services.component';
import {TopComponent} from './modules/layout/components/main/top/top.component';
import {HeaderComponent} from './modules/layout/components/personalAccount/header/header.component';
import {PersonalDataComponent} from './modules/layout/components/personalAccount/personal-data/personal-data.component';
import {ConnectedServicesComponent} from './modules/layout/components/personalAccount/connected-services/connected-services.component';
import {WalletComponent} from './modules/layout/components/personalAccount/wallet/wallet.component';
import {UserComponent} from './modules/layout/components/admin-page/user/user.component';
import {ServiceComponent} from './modules/layout/components/admin-page/user/service/service.component';
import {HeaderAdminComponent} from './modules/layout/components/admin-page/header-admin/header-admin.component';
import {ToastrService} from 'toastr-service/component';
import {NgFlashMessagesModule} from 'ng-flash-messages';
import {ToastrModule} from 'ngx-toastr';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

const routes: Routes = [
  {path: '' , redirectTo: 'main', pathMatch: 'full'},
  {path: 'main/personal-account', component: PersonalAccountComponent},
  {path: 'login', component: LoginComponent},
  {path: 'main', component: MainPageComponent},
  {path: 'register', component: RegisterComponent },
  {path: 'main/adminpage', component: AdminPageComponent}
];

@NgModule({
  declarations: [
    ConnectedServicesComponent,
    PersonalAccountComponent,
    ServicesComponent,
    TopComponent,
    LoginComponent,
    FaqComponent,
    HeaderMainComponent,
    MainPageComponent,
    RegisterComponent,
    HeaderComponent,
    PersonalDataComponent,
    WalletComponent,
    AdminPageComponent,
    UserComponent,
    BillingAccountComponent,
    ServiceComponent,
    HeaderAdminComponent,
    AppComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    HttpClientModule,
    BrowserModule,
    CommonModule,
    FormsModule,
    Ng4LoadingSpinnerModule.forRoot(),
    // LayoutModule,
    RouterModule.forRoot(routes),
    ToastrModule.forRoot({
      timeOut: 4000,
      positionClass: 'toast-top-left'
    }),
    NgFlashMessagesModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
