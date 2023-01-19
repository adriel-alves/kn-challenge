import { Person } from './../model/person';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.scss']
})
export class ContactListComponent implements OnInit{

  contactListDataSource: Person[] = [{_id: "1", name: "Homer Simpson", imgUrl: "https://vignette.wikia.nocookie.net/simpsons/images/b/bd/Homer_Simpson.png/revision/latest/scale-to-width-down/72?cb=20140126234206" }];
  displayedColumns=['name', 'imgUrl'];

  constructor() {
    // this.contactListDataSource = [];
  }
  ngOnInit(): void {

  }
}
