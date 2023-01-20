import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';

import { ContactListRoutingModule } from './contact-list-routing.module';
import { ContactListComponent } from './contact-list/contact-list.component';
import {MatCardModule} from '@angular/material/card';


@NgModule({
  declarations: [
    ContactListComponent
  ],
  imports: [
    CommonModule,
    ContactListRoutingModule,
    MatTableModule,
    MatCardModule,
    MatProgressSpinnerModule
  ]
})
export class ContactListModule { }
