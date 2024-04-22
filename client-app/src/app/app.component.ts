import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  constructor(
    private authService: AuthService,
    private router: Router,
  ) {

  }


  isSigned() {
    return this.authService.signingStatus();
  }

  logut() {
    this.authService.logout();
    this.router.navigate(['']);
  }


  main_page(): boolean {
    return this.router.url === '/';
  }
}
