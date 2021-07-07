import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FORGOT_PWD, SIGNIN, SIGNUP } from './AuthenticationRoutes';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { ForgotpwdComponent } from './forgotpwd/forgotpwd.component';

const routes: Routes = [
  {
    path: SIGNIN,
    component: SigninComponent,

  },
  {
    path: SIGNUP,
    component: SignupComponent,

  },
  {
    path: FORGOT_PWD,
    component: ForgotpwdComponent,

  },
  {
    path: '',
    pathMatch: 'full',
    redirectTo: SIGNIN,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
