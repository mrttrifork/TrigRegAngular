import {Component, inject} from '@angular/core';
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {LoginService} from "../../generated";
import {firstValueFrom} from 'rxjs/internal/firstValueFrom';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatIconModule,
    MatButtonModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  private loginService = inject(LoginService);

  async login(): Promise<void> {
    console.log('start login');
    await firstValueFrom(this.loginService.login());
  }
}
