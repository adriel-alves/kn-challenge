import { TestBed } from '@angular/core/testing';

import { ContactlistserviceService } from './contactlistservice.service';

describe('ContactlistserviceService', () => {
  let service: ContactlistserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContactlistserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
