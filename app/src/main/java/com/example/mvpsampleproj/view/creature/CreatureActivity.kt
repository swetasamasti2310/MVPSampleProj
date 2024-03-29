package com.example.mvpsampleproj.view.creature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.mvpsampleproj.R
import com.example.mvpsampleproj.model.AttributeStore
import com.example.mvpsampleproj.model.AttributeType
import com.example.mvpsampleproj.model.AttributeValue
import com.example.mvpsampleproj.model.Avatar
import com.example.mvpsampleproj.presenter.CreatureContract
import com.example.mvpsampleproj.presenter.CreaturePresenter
import com.example.mvpsampleproj.view.avatars.AvatarAdapter
import com.example.mvpsampleproj.view.avatars.AvatarBottomDialogFragment
import kotlinx.android.synthetic.main.activity_creature.*

class CreatureActivity : AppCompatActivity(), AvatarAdapter.AvatarListener, CreatureContract.View {

    private val presenter = CreaturePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creature)

        presenter.setView(this)

        configureUI()
        configureSpinnerAdapters()
        configureSpinnerListeners()
        configureEditText()
        configureClickListeners()
    }

    private fun configureUI() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = getString(R.string.add_creature)

        if (presenter.isDrawableSelected()) hideTapLabel()
    }

    private fun configureSpinnerAdapters() {
        intelligence.adapter = ArrayAdapter<AttributeValue>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            AttributeStore.INTELLIGENCE
        )
        strength.adapter = ArrayAdapter<AttributeValue>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            AttributeStore.STRENGTH
        )
        endurance.adapter = ArrayAdapter<AttributeValue>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            AttributeStore.ENDURENCE
        )
    }

    private fun configureSpinnerListeners() {
        intelligence.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.attributeSelected(AttributeType.INTELLIGENCE, position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        strength.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.attributeSelected(AttributeType.STRENGTH, position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        endurance.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.attributeSelected(AttributeType.ENDURENCE, position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun configureEditText() {
        nameEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.updateName(s.toString())
            }
        })
    }

    private fun configureClickListeners() {
        avatarImageView.setOnClickListener {
            val bottomDialogFragment = AvatarBottomDialogFragment.newInstance()
            bottomDialogFragment.show(supportFragmentManager, "AvatarBottomDialogFragment")
        }

        saveButton.setOnClickListener {
            presenter.saveCreature()
        }
    }

    override fun avatarClicked(avatar: Avatar) {
        presenter.drawableSelected(avatar.drawable)
        hideTapLabel()
    }

    private fun hideTapLabel() {
        tapLabel.visibility = View.INVISIBLE
    }

    override fun showHitPoints(hitPoints: String) {
        this.hitPoints.text = hitPoints
    }

    override fun showAvatarDrawable(resourceId: Int) {
        avatarImageView.setImageResource(resourceId)
    }

    override fun showCreatureSaved() {
        Toast.makeText(this, getString(R.string.creature_saved), Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun showCreatureSaveError() {
        Toast.makeText(this, getString(R.string.error_saving_creatures), Toast.LENGTH_SHORT).show()
    }

}
