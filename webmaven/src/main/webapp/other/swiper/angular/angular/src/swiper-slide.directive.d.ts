import * as i0 from '@angular/core';
import {TemplateRef} from '@angular/core';

export declare class SwiperSlideDirective {
    static ɵfac: i0.ɵɵFactoryDeclaration<SwiperSlideDirective, never>;
    static ɵdir: i0.ɵɵDirectiveDeclaration<SwiperSlideDirective, "ng-template[swiperSlide]", never, { "virtualIndex": "virtualIndex"; "class": "class"; "ngClass": "ngClass"; "autoplayDelay": "data-swiper-autoplay"; "zoom": "zoom"; }, {}, never>;
    template: TemplateRef<any>;
    virtualIndex: number;
    class: string;
    autoplayDelay: string | null;
    slideIndex: number;
    slideData: {
        isActive: boolean;
        isPrev: boolean;
        isNext: boolean;
        isVisible: boolean;
        isDuplicate: boolean;
    };
    private _hasClass;

    constructor(template: TemplateRef<any>);

    set ngClass(val: string);

    private _zoom;

    get zoom(): boolean;

    set zoom(val: boolean);

    private _classNames;

    get classNames(): string;

    set classNames(val: string);
}
