import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material/table';

import { ContactListRoutingModule } from './contact-list-routing.module';
import { ContactListComponent } from './contact-list/contact-list.component';


@NgModule({
  declarations: [
    ContactListComponent
  ],
  imports: [
    CommonModule,
    ContactListRoutingModule,
    MatTableModule
  ]
})
export class ContactListModule { }
