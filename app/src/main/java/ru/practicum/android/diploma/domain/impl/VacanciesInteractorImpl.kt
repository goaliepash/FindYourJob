package ru.practicum.android.diploma.domain.impl

import kotlinx.coroutines.flow.Flow
import ru.practicum.android.diploma.domain.api.VacanciesInteractor
import ru.practicum.android.diploma.domain.api.VacanciesRepository
import ru.practicum.android.diploma.domain.models.Vacancies
import ru.practicum.android.diploma.domain.models.VacanciesRequest
import ru.practicum.android.diploma.domain.models.Vacancy
import ru.practicum.android.diploma.domain.models.VacancyDetails
import ru.practicum.android.diploma.util.SearchResult

class VacanciesInteractorImpl(private val vacanciesRepository: VacanciesRepository) : VacanciesInteractor {

    override suspend fun searchVacancies(vacanciesRequest: VacanciesRequest): Flow<SearchResult<Vacancies>> {
        return vacanciesRepository.searchVacancies(vacanciesRequest = vacanciesRequest)
    }

    override suspend fun getVacancyDetails(vacancyId: String): Flow<VacancyDetails> {
        return vacanciesRepository.getVacancyDetails(vacancyId = vacancyId)
    }

    override suspend fun getSimilarVacancies(vacancyId: String): Flow<Vacancies> {
        return vacanciesRepository.getSimilarVacancies(vacancyId = vacancyId)
    }

    override suspend fun addVacancyToFavorites(vacancy: VacancyDetails) {
        vacanciesRepository.addVacancyToFavorites(vacancy)
    }

    override suspend fun removeVacancyFromFavorites(vacancyId: String) {
        vacanciesRepository.removeVacancyFromFavorites(vacancyId)
    }

    override fun getFavoriteVacancies(): Flow<List<Vacancy>> {
        return vacanciesRepository.getFavoriteVacancies()
    }
}
