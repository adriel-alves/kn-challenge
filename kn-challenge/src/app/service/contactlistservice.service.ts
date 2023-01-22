import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from '../interface/page';

@Injectable({
  providedIn: 'root',
})
export class ContactListService {
  private readonly API = 'api/contact-list';

  constructor(private httpClient: HttpClient) {}

  contactList$ = (
    name: string = '',
    page: number = 0,
    size: number = 10
  ): Observable<Page> =>
    this.httpClient.get<Page>(
      `${this.API}?name=${name}&page=${page}&size=${size}`
    );
}
