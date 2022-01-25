package com.example.projectpassdawidpuka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.projectpassdawidpuka.R

class StaticticsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statictics)

        val biologyStats = findViewById<Button>(R.id.showStatisticsBiology)
        biologyStats.setOnClickListener(goToShowBiologyStats)

        val chemistryStats = findViewById<Button>(R.id.showStatisticsChemistry)
        chemistryStats.setOnClickListener(goToShowChemistryStats)

        val historyStats = findViewById<Button>(R.id.showStatisticsHistory)
        historyStats.setOnClickListener(goToShowHistoryStats)
        val mathStats = findViewById<Button>(R.id.showStatisticsMath)
        mathStats.setOnClickListener(goToShowMathStats)

    }

    private val goToShowBiologyStats =
        View.OnClickListener { callSecondActivityBiologyStats() }

    fun callSecondActivityBiologyStats() {
        val intentWithResult = Intent(this, BiologyStatsActivity::class.java)
        startActivityForResult(intentWithResult, 2)

    }

    private val goToShowMathStats =
        View.OnClickListener { callSecondActivityMathStats() }

    fun callSecondActivityMathStats() {
        val intentWithResult = Intent(this, MathStatsActivity::class.java)
        startActivityForResult(intentWithResult, 2)

    }

    private val goToShowChemistryStats =
        View.OnClickListener { callSecondActivityChemistryStats() }

    fun callSecondActivityChemistryStats() {
        val intentWithResult = Intent(this, ChemistryStatsActivity::class.java)
        startActivityForResult(intentWithResult, 2)

    }

    private val goToShowHistoryStats =
        View.OnClickListener { callSecondActivityHistoryStats() }

    fun callSecondActivityHistoryStats() {
        val intentWithResult = Intent(this, HistoryStatsActivity::class.java)
        startActivityForResult(intentWithResult, 2)

    }

}