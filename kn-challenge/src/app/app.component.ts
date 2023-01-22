import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { BehaviorSubject, catchError, map, Observable, of, startWith } from 'rxjs';

import { Page } from './interface/page';
import { ContactListService } from './service/contactlistservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  contactLisStatet$: Observable<{ appState: String, appData?: Page, error?: HttpErrorResponse }>;
  responseSubject = new BehaviorSubject<Page>(null);
  private currentPageSubject = new BehaviorSubject<number>(0);
  private totalPagesSubject = new BehaviorSubject<number>(0);
  currentPage$ = this.currentPageSubject.asObservable();
  constructor(private contactListService: ContactListService, private sanitizer: DomSanitizer) { }

    ngOnInit(): void {
      this.contactLisStatet$ = this.contactListService.contactList$().pipe(
        map((response: Page) => {
          this.responseSubject.next(response);
          this.currentPageSubject.next(response.pageable.pageNumber);
          return ({appState: 'APP_LOADED', appData: response});
        }
      ),
      startWith({appState: 'APP_LOADING'}),
      catchError((error: HttpErrorResponse) => of({appState: 'APP_ERROR', error})),
      )}

      sanitizeImageUrl(imageUrl: string): SafeUrl {
        return this.sanitizer.bypassSecurityTrustUrl(imageUrl);
      }

      goToPage(name?:string, pageNumber: number = 0): void {
        this.contactLisStatet$ = this.contactListService.contactList$(name, pageNumber).pipe(
          map((response: Page) => {
            this.responseSubject.next(response);
            this.currentPageSubject.next(pageNumber);
            return ({appState: 'APP_LOADED', appData: response});
          }
        ),
        startWith({appState: 'APP_LOADED', appData: this.responseSubject.value }),
        catchError((error: HttpErrorResponse) => of({appState: 'APP_ERROR', error})),
        )}

      goToNextOrPrevious(direction?: string, name?: string): void {
        this.goToPage(name, direction === 'foward' ? this.currentPageSubject.value + 1: this.currentPageSubject.value - 1);
      }

      limitTotalPages(totalPage: number): number {
          if(totalPage < 10) {
            return totalPage
          } else {
            return 10
          }
      }
    }


