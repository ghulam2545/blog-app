import { Component } from '@angular/core';
import { LocalStorageService } from '../../services/local-storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

  username: string | null;

  constructor(
    private localStorage: LocalStorageService,
  ) {
    this.username = this.localStorage.get('username') != null ? this.localStorage.get('username') : 'NA';
  }

}
