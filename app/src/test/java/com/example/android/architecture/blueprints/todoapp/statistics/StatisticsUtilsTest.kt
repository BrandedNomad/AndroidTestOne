package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.TestCase
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred(){
        //GIVEN a list of tasks with a single, active, task
        val tasks = listOf<Task>(
            Task("title","description",isCompleted = false)
        )

        //WHEN you call getActiveAndCompleteStats
        val result = getActiveAndCompletedStats(tasks)

        //THEN there are 0% completed tasks and 100% active tasks
        assertThat(result.completedTasksPercent, equalTo(0f))
        assertThat(result.activeTasksPercent,equalTo(100f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty(){
        val tasks = listOf<Task>(
            Task("title","description",isCompleted = true),
            Task("title","description",isCompleted = true),
            Task("title","description",isCompleted = false),
            Task("title","description",isCompleted = false),
            Task("title","description",isCompleted = false)

        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(40f,result.completedTasksPercent)
        assertEquals(60f,result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros(){
        val tasks = listOf<Task>()
        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f,result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros(){
        val tasks = null
        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f,result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)
    }


}