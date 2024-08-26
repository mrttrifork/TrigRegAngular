import {Component, inject, OnInit} from '@angular/core';
import {Router, RouterOutlet} from '@angular/router';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {firstValueFrom} from "rxjs/internal/firstValueFrom";
import {LoginService} from "./generated";
import {LogoutService} from "./service/logout.service";
import {MatTooltip} from "@angular/material/tooltip";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatSidenavModule, MatToolbarModule, MatIconModule, MatButtonModule, MatTooltip],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'TriRegAngular';

  private readonly logoutService = inject(LogoutService);

  async logout(): Promise<void> {
    console.log('start logoff');
    await firstValueFrom(this.logoutService.logout());
  }
}
