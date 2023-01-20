import { TestBed } from '@angular/core/testing';

import { ContactListServiceService } from './contact-list-service.service';

describe('ContactListServiceService', () => {
  let service: ContactListServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContactListServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
