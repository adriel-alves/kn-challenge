import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { catchError, map, Observable, of, startWith } from 'rxjs';

import { Page } from './interface/page';
import { ContactListService } from './service/contactlistservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  contactLisStatet$: Observable<{ appState: String, appData?: Page, error?: HttpErrorResponse }>;
  constructor(private contactListService: ContactListService, private sanitizer: DomSanitizer) { }

    ngOnInit(): void {
      this.contactLisStatet$ = this.contactListService.contactList$().pipe(
        map((response: Page) => {
          console.log(response);
          return ({appState: 'APP_LOADED', appData: response});
        }
      ),
      startWith({appState: 'APP_LOADING'}),
      catchError((error: HttpErrorResponse) => of({appState: 'APP_ERROR', error})),
      )}

      sanitizeImageUrl(imageUrl: string): SafeUrl {
        return this.sanitizer.bypassSecurityTrustUrl(imageUrl);
      }
    }


