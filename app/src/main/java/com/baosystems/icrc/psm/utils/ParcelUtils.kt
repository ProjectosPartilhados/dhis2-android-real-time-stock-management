package com.baosystems.icrc.psm.utils

import com.baosystems.icrc.psm.data.models.IdentifiableModel
import org.hisp.dhis.android.core.option.Option
import org.hisp.dhis.android.core.organisationunit.OrganisationUnit

object ParcelUtils {
    fun facilityToIdentifiableModelParcel(ou: OrganisationUnit): IdentifiableModel =
        IdentifiableModel(ou.uid(), ou.name()!!, ou.displayName()!!)

    fun distributedTo_ToIdentifiableModelParcel(option: Option): IdentifiableModel =
        IdentifiableModel(option.uid(), option.name()!!, option.displayName()!!)
}