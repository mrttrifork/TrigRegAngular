import {Component, inject} from '@angular/core';
import {OidcSecurityService} from "angular-auth-oidc-client";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";

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

    private readonly oidcSecurityService = inject(OidcSecurityService);

    login(): void {
        console.log('start login');
        this.oidcSecurityService.authorize();
    }
}
