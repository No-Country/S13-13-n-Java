/* import { trigger, style, animate, transition } from '@angular/animations';

export const rotateAnimation = trigger('rotateEffect', [
  transition(':enter', [
    style({ transform: 'rotate(0deg)' }),
    animate('1s', style({ transform: 'rotate(360deg)' })),
  ]),
]);
 */
import { trigger, style, animate, transition } from '@angular/animations';

export const rotateAnimation = trigger('rotateEffect', [
  transition(':enter', [
    style({ transform: 'rotate(0deg)' }),
    animate('1s 500ms', style({ transform: 'rotate(360deg)' })),
  ]),
]);
