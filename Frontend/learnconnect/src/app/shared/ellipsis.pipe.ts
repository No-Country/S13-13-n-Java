import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ellipsis'
})
export class EllipsisPipe implements PipeTransform {

  /*Este pipe recibe un texto y devuelve el mismo texto truncado con puntos suspensivos si supera cierta longitud */
  transform(value: string, maxLength: number = 21): string {
    if (value.length <= maxLength) {
      return value;
    } else {
      return value.substring(0, maxLength) + '...';
    }
  }
}
