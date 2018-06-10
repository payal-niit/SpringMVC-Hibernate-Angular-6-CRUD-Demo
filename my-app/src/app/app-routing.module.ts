import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './user/user.component';

import { UserDetailComponent } from './user-detail/user-detail.component';

const routes:Routes =[
  { path: 'detail/:userId', component: UserDetailComponent },
  { path: 'user' , component: UserComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ],
  declarations: []
})
export class AppRoutingModule { }
