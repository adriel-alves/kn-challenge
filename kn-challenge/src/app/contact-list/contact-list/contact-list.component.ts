import { ErrorDialogComponent } from './../../components/error-dialog/error-dialog.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';

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

  constructor(
    private contactListService: ContactListService,
    public dialog: MatDialog
    ) {
    this.contactList$ = contactListService.list()
    .pipe(
      catchError(error => {
        this.onError('An error occurred when trying to fetch contact list');
        return of([])
      })
    );
  }

  onError(errorMsg: String) {
      this.dialog.open(
        ErrorDialogComponent, {
          data: errorMsg
        });
  }
  ngOnInit(): void {

  }
}
