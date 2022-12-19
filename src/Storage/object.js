import { action } from "easy-peasy";

export const form = {
  Pontuacao: 0,
  setForm: action((state, payload) => {
    state.Pontuacao = payload;
  }),

  light: true,
  setTema: action((state) => {
    state.light = !state.light;
  }),
};
