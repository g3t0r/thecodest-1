export interface Page<T> {
  number: number;
  content: T[],
  totalElements: number,
  totalPages: number,
  first: boolean,
  last: boolean,
  empty: boolean,
  numberOfElements: number
}
