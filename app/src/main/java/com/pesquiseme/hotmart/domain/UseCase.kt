package com.pesquiseme.hotmart.domain

import kotlinx.coroutines.CoroutineScope

interface UseCase<out Res, out Err, in Params> {
    fun execute(
        params: Params,
        coroutineScope: CoroutineScope,
        onStart: () -> Unit,
        onFinished: () -> Unit,
        onSuccess: (Res) -> Unit,
        onFailure: (Err) -> Unit
    )
}