import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginForm: FormGroup;

  constructor(
    private authService: AuthService,
    private builder: FormBuilder,
    private router: Router) {
    this.loginForm = this.builder.group({
      username: [null, Validators.required],
      password: [null, Validators.required],
    });
  }

  onSubmit() {
    this.login();

  }


  login() {
    const { username, password } = this.loginForm.value;
    this.authService.login(username, password).subscribe({
      next: res => {
        const { username, token } = res as any;
        this.authService.storeInfo(username, token)
        this.router.navigate(['/home']);
      },
      error: error => {
        console.error(error);
      }
    });
  }
}
