
import {createStore,persist} from 'easy-peasy';
import {form} from './object';

export const store = createStore(persist(form));