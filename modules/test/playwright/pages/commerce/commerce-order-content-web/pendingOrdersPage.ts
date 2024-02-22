/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {Locator, Page} from '@playwright/test';

import {CommerceLayoutsPage} from '../commerceLayoutsPage';

export class PendingOrdersPage {
	readonly addPendingOrdersLabel: Locator;
	readonly addWidgetButton: Locator;
	readonly layoutsPage: CommerceLayoutsPage;
	readonly orderItemActionsButton: Locator;
	readonly orderItemEditActionButton: Locator;
	readonly page: Page;
	readonly pageLabel: Locator;
	readonly pageTitle: Locator;
	readonly panelList: Locator;
	readonly searchFormInput: Locator;
	readonly viewButton: Locator;

	constructor(page: Page) {
		this.addPendingOrdersLabel = page
			.getByTestId('addPanelTabItem')
			.filter({hasText: /^Open Carts$/})
			.getByRole('button', {exact: true, name: 'Add Content'});
		this.addWidgetButton = page.getByTestId('add');
		this.layoutsPage = new CommerceLayoutsPage(page);
		this.orderItemActionsButton = page.getByRole('button', {
			name: 'Actions',
		});
		this.orderItemEditActionButton = page.getByRole('menuitem', {
			name: 'Edit',
		});
		this.page = page;
		this.pageLabel = page
			.getByTestId('layoutHref')
			.getByLabel('Pending Orders Page');
		this.pageTitle = page
			.getByTestId('headerTitle')
			.filter({hasText: 'Pending Orders Page'});
		this.panelList = page
			.getByTestId('specificationFacetPanel')
			.getByRole('button');
		this.searchFormInput = page.getByRole('textbox', {
			name: 'Search Form',
		});
		this.viewButton = page.getByLabel('View');
	}

	async addPendingOrdersWidget() {
		await this.addWidgetButton.click();
		await this.searchFormInput.click();
		await this.searchFormInput.fill('Open Carts');
		await this.addPendingOrdersLabel.click();
	}

	async goto() {
		await this.layoutsPage.goto();
	}
}
