import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { LocalStorageService } from './services/local-storage.service';

@Injectable()
export class HttpClientInterceptor implements HttpInterceptor {
    constructor(private $localStorage: LocalStorageService) {

    }

    intercept(req: HttpRequest<any>,
        next: HttpHandler): Observable<HttpEvent<any>> {

        const token = this.$localStorage.get("token");
        console.log('jwt token ' + token);
        if (token) {
            const cloned = req.clone({
                headers: req.headers.set("Authorization",
                    "Bearer " + token)
            });

            return next.handle(cloned);
        }
        else {
            return next.handle(req);
        }
    }
}