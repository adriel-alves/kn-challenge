import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, tap } from 'rxjs';

import { Person } from './../model/person';

@Injectable({
  providedIn: 'root'
})
export class ContactListService {

private readonly API = 'http://localhost:8080/api/contact-list';

  constructor(private httpClient: HttpClient) { }

  list(){
    return this.httpClient.get<Person[]>(this.API)
    .pipe(
      first(),
      delay(5000),
      tap(contactList => console.log(contactList))
      );
  }
}
