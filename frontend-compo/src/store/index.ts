import Vue from "vue";
import Vuex from "vuex";
import ApiService from '@/api/api.service';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    team1loadingStatus: 'notLoading',
    team2loadingStatus: 'notLoading',
    team1: {

    },
    team2: {

    }
  },
  mutations: {
    SET_TEAM1_LOADING_STATUS(state, status) {
      state.team1loadingStatus = status;
    },
    SET_TEAM2_LOADING_STATUS(state, status) {
      state.team2loadingStatus = status;
    },
    SET_TEAM1(state, team1) {
      state.team1 = team1;
    },
    SET_TEAM2(state, team2) {
      state.team2 = team2;
    }
  },
  actions: {
    fetchTeam1(context, team1) {
      context.commit('SET_TEAM1_LOADING_STATUS', 'loading');
      ApiService.getTeam(team1).then((res) => {
        context.commit('SET_TEAM1_LOADING_STATUS', 'notLoading');
        context.commit('SET_TEAM1', res.data)
      })
    },
    fetchTeam2(context, team2) {
      context.commit('SET_TEAM2_LOADING_STATUS', 'loading');
      ApiService.getTeam(team2).then((res) => {
        context.commit('SET_TEAM2_LOADING_STATUS', 'notLoading');
        context.commit('SET_TEAM2', res.data);
      })
    }
  },
  getters: {
    getTeam1(state) {
      return state.team1;
    },
    getTeam2(state) {
      return state.team2;
    }
  }
});
