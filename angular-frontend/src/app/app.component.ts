import {Component, inject, OnInit} from '@angular/core';
import {Router, RouterOutlet} from '@angular/router';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {firstValueFrom} from "rxjs/internal/firstValueFrom";
import {LoginService} from "./generated";
import {LogoutService} from "./service/logout.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatSidenavModule, MatToolbarModule, MatIconModule, MatButtonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'TriRegAngular';

  private readonly router = inject(Router);
  private readonly loginService = inject(LoginService);
  private readonly logoutService = inject(LogoutService);

  async login(): Promise<void> {
    console.log('start login');
    await firstValueFrom(this.loginService.login());
  }

  async logout(): Promise<void> {
    console.log('start logoff');
    await firstValueFrom(this.logoutService.logout());
  }
}
