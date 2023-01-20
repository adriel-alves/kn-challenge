import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Person } from './../model/person';
import { ContactListService } from './../services/contact-list.service';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.scss']
})
export class ContactListComponent implements OnInit{

  contactList$: Observable<Person[]>;
  displayedColumns=['name', 'imgUrl'];

  constructor(private contactListService: ContactListService) {
    this.contactList$ = contactListService.list();
  }
  ngOnInit(): void {

  }
}
