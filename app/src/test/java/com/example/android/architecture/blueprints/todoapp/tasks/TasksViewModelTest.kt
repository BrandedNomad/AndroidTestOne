package com.example.android.architecture.blueprints.todoapp.tasks


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {
    //Runs tasks on a single thread
    //Ensures that tasks are run synchronously and in a repeatable order
    //used to test live data
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addNewTask_setsNewTAskEvent(){
        //Given a fresh ViewModel
        val taskViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        //When adding a new task
        taskViewModel.addNewTask()

        //Then the new task event is triggered
        val value = taskViewModel.newTaskEvent.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled(),not(nullValue()))
    }
}