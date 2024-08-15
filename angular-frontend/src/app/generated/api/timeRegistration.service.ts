/**
 * TriReg2 User API
 * An OpenAPI specification for time registrations to be used by a user
 *
 * The version of the OpenAPI document: 0.2.0
 * Contact: example@example.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
/* tslint:disable:no-unused-variable member-ordering */

import { Inject, Injectable, Optional }                      from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,
         HttpResponse, HttpEvent, HttpParameterCodec, HttpContext 
        }       from '@angular/common/http';
import { CustomHttpParameterCodec }                          from '../encoder';
import { Observable }                                        from 'rxjs';

// @ts-ignore
import { PeriodEnum } from '../model/periodEnum';
// @ts-ignore
import { TimeRegistrationRequest } from '../model/timeRegistrationRequest';
// @ts-ignore
import { TimeRegistrationResponse } from '../model/timeRegistrationResponse';
// @ts-ignore
import { TimeRegistrationUpdateRequest } from '../model/timeRegistrationUpdateRequest';
// @ts-ignore
import { TimeRegistrationsByTaskResponseInner } from '../model/timeRegistrationsByTaskResponseInner';

// @ts-ignore
import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';



@Injectable({
  providedIn: 'root'
})
export class TimeRegistrationService {

    protected basePath = 'https://trireg2.tcs.trifork.dev';
    public defaultHeaders = new HttpHeaders();
    public configuration = new Configuration();
    public encoder: HttpParameterCodec;

    constructor(protected httpClient: HttpClient, @Optional()@Inject(BASE_PATH) basePath: string|string[], @Optional() configuration: Configuration) {
        if (configuration) {
            this.configuration = configuration;
        }
        if (typeof this.configuration.basePath !== 'string') {
            if (Array.isArray(basePath) && basePath.length > 0) {
                basePath = basePath[0];
            }

            if (typeof basePath !== 'string') {
                basePath = this.basePath;
            }
            this.configuration.basePath = basePath;
        }
        this.encoder = this.configuration.encoder || new CustomHttpParameterCodec();
    }


    // @ts-ignore
    private addToHttpParams(httpParams: HttpParams, value: any, key?: string): HttpParams {
        if (typeof value === "object" && value instanceof Date === false) {
            httpParams = this.addToHttpParamsRecursive(httpParams, value);
        } else {
            httpParams = this.addToHttpParamsRecursive(httpParams, value, key);
        }
        return httpParams;
    }

    private addToHttpParamsRecursive(httpParams: HttpParams, value?: any, key?: string): HttpParams {
        if (value == null) {
            return httpParams;
        }

        if (typeof value === "object") {
            if (Array.isArray(value)) {
                (value as any[]).forEach( elem => httpParams = this.addToHttpParamsRecursive(httpParams, elem, key));
            } else if (value instanceof Date) {
                if (key != null) {
                    httpParams = httpParams.append(key, (value as Date).toISOString().substring(0, 10));
                } else {
                   throw Error("key may not be null if value is Date");
                }
            } else {
                Object.keys(value).forEach( k => httpParams = this.addToHttpParamsRecursive(
                    httpParams, value[k], key != null ? `${key}.${k}` : k));
            }
        } else if (key != null) {
            httpParams = httpParams.append(key, value);
        } else {
            throw Error("key may not be null if value is not object or array");
        }
        return httpParams;
    }

    /**
     * Add several time registrations for a user
     * @param timeRegistrationRequest A JSON object containing a list of time registration information
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public addBulkTimeRegistrationForUser(timeRegistrationRequest: Array<TimeRegistrationRequest>, observe?: 'body', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<string>;
    public addBulkTimeRegistrationForUser(timeRegistrationRequest: Array<TimeRegistrationRequest>, observe?: 'response', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<HttpResponse<string>>;
    public addBulkTimeRegistrationForUser(timeRegistrationRequest: Array<TimeRegistrationRequest>, observe?: 'events', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<HttpEvent<string>>;
    public addBulkTimeRegistrationForUser(timeRegistrationRequest: Array<TimeRegistrationRequest>, observe: any = 'body', reportProgress: boolean = false, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<any> {
        if (timeRegistrationRequest === null || timeRegistrationRequest === undefined) {
            throw new Error('Required parameter timeRegistrationRequest was null or undefined when calling addBulkTimeRegistrationForUser.');
        }

        let localVarHeaders = this.defaultHeaders;

        let localVarCredential: string | undefined;
        // authentication (openId) required
        localVarCredential = this.configuration.lookupCredential('openId');
        if (localVarCredential) {
        }

        // authentication (basicAuth) required
        localVarCredential = this.configuration.lookupCredential('basicAuth');
        if (localVarCredential) {
            localVarHeaders = localVarHeaders.set('Authorization', 'Basic ' + localVarCredential);
        }

        let localVarHttpHeaderAcceptSelected: string | undefined = options && options.httpHeaderAccept;
        if (localVarHttpHeaderAcceptSelected === undefined) {
            // to determine the Accept header
            const httpHeaderAccepts: string[] = [
                'text/plain'
            ];
            localVarHttpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        }
        if (localVarHttpHeaderAcceptSelected !== undefined) {
            localVarHeaders = localVarHeaders.set('Accept', localVarHttpHeaderAcceptSelected);
        }

        let localVarHttpContext: HttpContext | undefined = options && options.context;
        if (localVarHttpContext === undefined) {
            localVarHttpContext = new HttpContext();
        }

        let localVarTransferCache: boolean | undefined = options && options.transferCache;
        if (localVarTransferCache === undefined) {
            localVarTransferCache = true;
        }


        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected !== undefined) {
            localVarHeaders = localVarHeaders.set('Content-Type', httpContentTypeSelected);
        }

        let responseType_: 'text' | 'json' | 'blob' = 'json';
        if (localVarHttpHeaderAcceptSelected) {
            if (localVarHttpHeaderAcceptSelected.startsWith('text')) {
                responseType_ = 'text';
            } else if (this.configuration.isJsonMime(localVarHttpHeaderAcceptSelected)) {
                responseType_ = 'json';
            } else {
                responseType_ = 'blob';
            }
        }

        let localVarPath = `/time-registration/bulk`;
        return this.httpClient.request<string>('post', `${this.configuration.basePath}${localVarPath}`,
            {
                context: localVarHttpContext,
                body: timeRegistrationRequest,
                responseType: <any>responseType_,
                withCredentials: this.configuration.withCredentials,
                headers: localVarHeaders,
                observe: observe,
                transferCache: localVarTransferCache,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Adds a time registration for a user
     * @param timeRegistrationRequest A JSON object containing time registration information
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public addTimeRegistrationForUser(timeRegistrationRequest: TimeRegistrationRequest, observe?: 'body', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<string>;
    public addTimeRegistrationForUser(timeRegistrationRequest: TimeRegistrationRequest, observe?: 'response', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<HttpResponse<string>>;
    public addTimeRegistrationForUser(timeRegistrationRequest: TimeRegistrationRequest, observe?: 'events', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<HttpEvent<string>>;
    public addTimeRegistrationForUser(timeRegistrationRequest: TimeRegistrationRequest, observe: any = 'body', reportProgress: boolean = false, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<any> {
        if (timeRegistrationRequest === null || timeRegistrationRequest === undefined) {
            throw new Error('Required parameter timeRegistrationRequest was null or undefined when calling addTimeRegistrationForUser.');
        }

        let localVarHeaders = this.defaultHeaders;

        let localVarCredential: string | undefined;
        // authentication (openId) required
        localVarCredential = this.configuration.lookupCredential('openId');
        if (localVarCredential) {
        }

        // authentication (basicAuth) required
        localVarCredential = this.configuration.lookupCredential('basicAuth');
        if (localVarCredential) {
            localVarHeaders = localVarHeaders.set('Authorization', 'Basic ' + localVarCredential);
        }

        let localVarHttpHeaderAcceptSelected: string | undefined = options && options.httpHeaderAccept;
        if (localVarHttpHeaderAcceptSelected === undefined) {
            // to determine the Accept header
            const httpHeaderAccepts: string[] = [
                'text/plain'
            ];
            localVarHttpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        }
        if (localVarHttpHeaderAcceptSelected !== undefined) {
            localVarHeaders = localVarHeaders.set('Accept', localVarHttpHeaderAcceptSelected);
        }

        let localVarHttpContext: HttpContext | undefined = options && options.context;
        if (localVarHttpContext === undefined) {
            localVarHttpContext = new HttpContext();
        }

        let localVarTransferCache: boolean | undefined = options && options.transferCache;
        if (localVarTransferCache === undefined) {
            localVarTransferCache = true;
        }


        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected !== undefined) {
            localVarHeaders = localVarHeaders.set('Content-Type', httpContentTypeSelected);
        }

        let responseType_: 'text' | 'json' | 'blob' = 'json';
        if (localVarHttpHeaderAcceptSelected) {
            if (localVarHttpHeaderAcceptSelected.startsWith('text')) {
                responseType_ = 'text';
            } else if (this.configuration.isJsonMime(localVarHttpHeaderAcceptSelected)) {
                responseType_ = 'json';
            } else {
                responseType_ = 'blob';
            }
        }

        let localVarPath = `/time-registration`;
        return this.httpClient.request<string>('post', `${this.configuration.basePath}${localVarPath}`,
            {
                context: localVarHttpContext,
                body: timeRegistrationRequest,
                responseType: <any>responseType_,
                withCredentials: this.configuration.withCredentials,
                headers: localVarHeaders,
                observe: observe,
                transferCache: localVarTransferCache,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Deletes the specified time registration
     * @param timeRegistrationId The id of the time registration to delete
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public deleteTimeRegistration(timeRegistrationId: number, observe?: 'body', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<string>;
    public deleteTimeRegistration(timeRegistrationId: number, observe?: 'response', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<HttpResponse<string>>;
    public deleteTimeRegistration(timeRegistrationId: number, observe?: 'events', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<HttpEvent<string>>;
    public deleteTimeRegistration(timeRegistrationId: number, observe: any = 'body', reportProgress: boolean = false, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<any> {
        if (timeRegistrationId === null || timeRegistrationId === undefined) {
            throw new Error('Required parameter timeRegistrationId was null or undefined when calling deleteTimeRegistration.');
        }

        let localVarQueryParameters = new HttpParams({encoder: this.encoder});
        if (timeRegistrationId !== undefined && timeRegistrationId !== null) {
          localVarQueryParameters = this.addToHttpParams(localVarQueryParameters,
            <any>timeRegistrationId, 'timeRegistrationId');
        }

        let localVarHeaders = this.defaultHeaders;

        let localVarCredential: string | undefined;
        // authentication (openId) required
        localVarCredential = this.configuration.lookupCredential('openId');
        if (localVarCredential) {
        }

        // authentication (basicAuth) required
        localVarCredential = this.configuration.lookupCredential('basicAuth');
        if (localVarCredential) {
            localVarHeaders = localVarHeaders.set('Authorization', 'Basic ' + localVarCredential);
        }

        let localVarHttpHeaderAcceptSelected: string | undefined = options && options.httpHeaderAccept;
        if (localVarHttpHeaderAcceptSelected === undefined) {
            // to determine the Accept header
            const httpHeaderAccepts: string[] = [
                'text/plain'
            ];
            localVarHttpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        }
        if (localVarHttpHeaderAcceptSelected !== undefined) {
            localVarHeaders = localVarHeaders.set('Accept', localVarHttpHeaderAcceptSelected);
        }

        let localVarHttpContext: HttpContext | undefined = options && options.context;
        if (localVarHttpContext === undefined) {
            localVarHttpContext = new HttpContext();
        }

        let localVarTransferCache: boolean | undefined = options && options.transferCache;
        if (localVarTransferCache === undefined) {
            localVarTransferCache = true;
        }


        let responseType_: 'text' | 'json' | 'blob' = 'json';
        if (localVarHttpHeaderAcceptSelected) {
            if (localVarHttpHeaderAcceptSelected.startsWith('text')) {
                responseType_ = 'text';
            } else if (this.configuration.isJsonMime(localVarHttpHeaderAcceptSelected)) {
                responseType_ = 'json';
            } else {
                responseType_ = 'blob';
            }
        }

        let localVarPath = `/time-registration`;
        return this.httpClient.request<string>('delete', `${this.configuration.basePath}${localVarPath}`,
            {
                context: localVarHttpContext,
                params: localVarQueryParameters,
                responseType: <any>responseType_,
                withCredentials: this.configuration.withCredentials,
                headers: localVarHeaders,
                observe: observe,
                transferCache: localVarTransferCache,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Returns time registrations for a user grouped by task
     * @param date The date to consider when fetching active tasks and time registrations
     * @param period The time period to use when deciding in which time period tasks are considered active
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public getTaskTimeRegistrationsOverview(date: string, period?: PeriodEnum, observe?: 'body', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json' | 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<Array<TimeRegistrationsByTaskResponseInner>>;
    public getTaskTimeRegistrationsOverview(date: string, period?: PeriodEnum, observe?: 'response', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json' | 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<HttpResponse<Array<TimeRegistrationsByTaskResponseInner>>>;
    public getTaskTimeRegistrationsOverview(date: string, period?: PeriodEnum, observe?: 'events', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json' | 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<HttpEvent<Array<TimeRegistrationsByTaskResponseInner>>>;
    public getTaskTimeRegistrationsOverview(date: string, period?: PeriodEnum, observe: any = 'body', reportProgress: boolean = false, options?: {httpHeaderAccept?: 'application/json' | 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<any> {
        if (date === null || date === undefined) {
            throw new Error('Required parameter date was null or undefined when calling getTaskTimeRegistrationsOverview.');
        }

        let localVarQueryParameters = new HttpParams({encoder: this.encoder});
        if (date !== undefined && date !== null) {
          localVarQueryParameters = this.addToHttpParams(localVarQueryParameters,
            <any>date, 'date');
        }
        if (period !== undefined && period !== null) {
          localVarQueryParameters = this.addToHttpParams(localVarQueryParameters,
            <any>period, 'period');
        }

        let localVarHeaders = this.defaultHeaders;

        let localVarCredential: string | undefined;
        // authentication (openId) required
        localVarCredential = this.configuration.lookupCredential('openId');
        if (localVarCredential) {
        }

        // authentication (basicAuth) required
        localVarCredential = this.configuration.lookupCredential('basicAuth');
        if (localVarCredential) {
            localVarHeaders = localVarHeaders.set('Authorization', 'Basic ' + localVarCredential);
        }

        let localVarHttpHeaderAcceptSelected: string | undefined = options && options.httpHeaderAccept;
        if (localVarHttpHeaderAcceptSelected === undefined) {
            // to determine the Accept header
            const httpHeaderAccepts: string[] = [
                'application/json',
                'text/plain'
            ];
            localVarHttpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        }
        if (localVarHttpHeaderAcceptSelected !== undefined) {
            localVarHeaders = localVarHeaders.set('Accept', localVarHttpHeaderAcceptSelected);
        }

        let localVarHttpContext: HttpContext | undefined = options && options.context;
        if (localVarHttpContext === undefined) {
            localVarHttpContext = new HttpContext();
        }

        let localVarTransferCache: boolean | undefined = options && options.transferCache;
        if (localVarTransferCache === undefined) {
            localVarTransferCache = true;
        }


        let responseType_: 'text' | 'json' | 'blob' = 'json';
        if (localVarHttpHeaderAcceptSelected) {
            if (localVarHttpHeaderAcceptSelected.startsWith('text')) {
                responseType_ = 'text';
            } else if (this.configuration.isJsonMime(localVarHttpHeaderAcceptSelected)) {
                responseType_ = 'json';
            } else {
                responseType_ = 'blob';
            }
        }

        let localVarPath = `/time-registration/active-task`;
        return this.httpClient.request<Array<TimeRegistrationsByTaskResponseInner>>('get', `${this.configuration.basePath}${localVarPath}`,
            {
                context: localVarHttpContext,
                params: localVarQueryParameters,
                responseType: <any>responseType_,
                withCredentials: this.configuration.withCredentials,
                headers: localVarHeaders,
                observe: observe,
                transferCache: localVarTransferCache,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Returns time registrations that belongs to a user
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public getTimeRegistrationsForUser(observe?: 'body', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext, transferCache?: boolean}): Observable<Array<TimeRegistrationResponse>>;
    public getTimeRegistrationsForUser(observe?: 'response', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext, transferCache?: boolean}): Observable<HttpResponse<Array<TimeRegistrationResponse>>>;
    public getTimeRegistrationsForUser(observe?: 'events', reportProgress?: boolean, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext, transferCache?: boolean}): Observable<HttpEvent<Array<TimeRegistrationResponse>>>;
    public getTimeRegistrationsForUser(observe: any = 'body', reportProgress: boolean = false, options?: {httpHeaderAccept?: 'application/json', context?: HttpContext, transferCache?: boolean}): Observable<any> {

        let localVarHeaders = this.defaultHeaders;

        let localVarCredential: string | undefined;
        // authentication (openId) required
        localVarCredential = this.configuration.lookupCredential('openId');
        if (localVarCredential) {
        }

        // authentication (basicAuth) required
        localVarCredential = this.configuration.lookupCredential('basicAuth');
        if (localVarCredential) {
            localVarHeaders = localVarHeaders.set('Authorization', 'Basic ' + localVarCredential);
        }

        let localVarHttpHeaderAcceptSelected: string | undefined = options && options.httpHeaderAccept;
        if (localVarHttpHeaderAcceptSelected === undefined) {
            // to determine the Accept header
            const httpHeaderAccepts: string[] = [
                'application/json'
            ];
            localVarHttpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        }
        if (localVarHttpHeaderAcceptSelected !== undefined) {
            localVarHeaders = localVarHeaders.set('Accept', localVarHttpHeaderAcceptSelected);
        }

        let localVarHttpContext: HttpContext | undefined = options && options.context;
        if (localVarHttpContext === undefined) {
            localVarHttpContext = new HttpContext();
        }

        let localVarTransferCache: boolean | undefined = options && options.transferCache;
        if (localVarTransferCache === undefined) {
            localVarTransferCache = true;
        }


        let responseType_: 'text' | 'json' | 'blob' = 'json';
        if (localVarHttpHeaderAcceptSelected) {
            if (localVarHttpHeaderAcceptSelected.startsWith('text')) {
                responseType_ = 'text';
            } else if (this.configuration.isJsonMime(localVarHttpHeaderAcceptSelected)) {
                responseType_ = 'json';
            } else {
                responseType_ = 'blob';
            }
        }

        let localVarPath = `/time-registration`;
        return this.httpClient.request<Array<TimeRegistrationResponse>>('get', `${this.configuration.basePath}${localVarPath}`,
            {
                context: localVarHttpContext,
                responseType: <any>responseType_,
                withCredentials: this.configuration.withCredentials,
                headers: localVarHeaders,
                observe: observe,
                transferCache: localVarTransferCache,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Updates the specified time registration
     * @param timeRegistrationId The id of the time registration to update
     * @param timeRegistrationUpdateRequest 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public updateTimeRegistrationForUser(timeRegistrationId: number, timeRegistrationUpdateRequest: TimeRegistrationUpdateRequest, observe?: 'body', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<string>;
    public updateTimeRegistrationForUser(timeRegistrationId: number, timeRegistrationUpdateRequest: TimeRegistrationUpdateRequest, observe?: 'response', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<HttpResponse<string>>;
    public updateTimeRegistrationForUser(timeRegistrationId: number, timeRegistrationUpdateRequest: TimeRegistrationUpdateRequest, observe?: 'events', reportProgress?: boolean, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<HttpEvent<string>>;
    public updateTimeRegistrationForUser(timeRegistrationId: number, timeRegistrationUpdateRequest: TimeRegistrationUpdateRequest, observe: any = 'body', reportProgress: boolean = false, options?: {httpHeaderAccept?: 'text/plain', context?: HttpContext, transferCache?: boolean}): Observable<any> {
        if (timeRegistrationId === null || timeRegistrationId === undefined) {
            throw new Error('Required parameter timeRegistrationId was null or undefined when calling updateTimeRegistrationForUser.');
        }
        if (timeRegistrationUpdateRequest === null || timeRegistrationUpdateRequest === undefined) {
            throw new Error('Required parameter timeRegistrationUpdateRequest was null or undefined when calling updateTimeRegistrationForUser.');
        }

        let localVarQueryParameters = new HttpParams({encoder: this.encoder});
        if (timeRegistrationId !== undefined && timeRegistrationId !== null) {
          localVarQueryParameters = this.addToHttpParams(localVarQueryParameters,
            <any>timeRegistrationId, 'timeRegistrationId');
        }

        let localVarHeaders = this.defaultHeaders;

        let localVarCredential: string | undefined;
        // authentication (openId) required
        localVarCredential = this.configuration.lookupCredential('openId');
        if (localVarCredential) {
        }

        // authentication (basicAuth) required
        localVarCredential = this.configuration.lookupCredential('basicAuth');
        if (localVarCredential) {
            localVarHeaders = localVarHeaders.set('Authorization', 'Basic ' + localVarCredential);
        }

        let localVarHttpHeaderAcceptSelected: string | undefined = options && options.httpHeaderAccept;
        if (localVarHttpHeaderAcceptSelected === undefined) {
            // to determine the Accept header
            const httpHeaderAccepts: string[] = [
                'text/plain'
            ];
            localVarHttpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        }
        if (localVarHttpHeaderAcceptSelected !== undefined) {
            localVarHeaders = localVarHeaders.set('Accept', localVarHttpHeaderAcceptSelected);
        }

        let localVarHttpContext: HttpContext | undefined = options && options.context;
        if (localVarHttpContext === undefined) {
            localVarHttpContext = new HttpContext();
        }

        let localVarTransferCache: boolean | undefined = options && options.transferCache;
        if (localVarTransferCache === undefined) {
            localVarTransferCache = true;
        }


        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected !== undefined) {
            localVarHeaders = localVarHeaders.set('Content-Type', httpContentTypeSelected);
        }

        let responseType_: 'text' | 'json' | 'blob' = 'json';
        if (localVarHttpHeaderAcceptSelected) {
            if (localVarHttpHeaderAcceptSelected.startsWith('text')) {
                responseType_ = 'text';
            } else if (this.configuration.isJsonMime(localVarHttpHeaderAcceptSelected)) {
                responseType_ = 'json';
            } else {
                responseType_ = 'blob';
            }
        }

        let localVarPath = `/time-registration`;
        return this.httpClient.request<string>('put', `${this.configuration.basePath}${localVarPath}`,
            {
                context: localVarHttpContext,
                body: timeRegistrationUpdateRequest,
                params: localVarQueryParameters,
                responseType: <any>responseType_,
                withCredentials: this.configuration.withCredentials,
                headers: localVarHeaders,
                observe: observe,
                transferCache: localVarTransferCache,
                reportProgress: reportProgress
            }
        );
    }

}
