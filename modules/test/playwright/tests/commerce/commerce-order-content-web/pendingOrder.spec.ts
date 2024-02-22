/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {expect, mergeTests} from '@playwright/test';

import {apiHelpersTest} from '../../../fixtures/apiHelpersTest';
import {applicationsMenuPageTest} from '../../../fixtures/applicationsMenuPageTest';
import {commercePagesTest} from '../../../fixtures/commercePagesTest';
import {loginTest} from '../../../fixtures/loginTest';

export const test = mergeTests(
	apiHelpersTest,
	applicationsMenuPageTest,
	commercePagesTest,
	loginTest
);

const data = [];

test.afterEach(async ({apiHelpers}) => {
	for await (const item of data.reverse()) {
		switch (item.type) {
			case 'catalog':
				await apiHelpers.headlessCommerceAdminCatalog.deleteCatalog(
					item.id
				);

				break;
			case 'channel':
				await apiHelpers.headlessCommerceAdminChannel.deleteChannel(
					item.id
				);

				break;
			case 'product':
				await apiHelpers.headlessCommerceAdminCatalog.deleteProduct(
					item.id
				);

				break;
			case 'site':
				await apiHelpers.headlessSite.deleteSite(item.id);

				break;
			default:
				break;
		}
	}
});

test('Edit pending order item with UOM', async ({
	apiHelpers,
	applicationsMenuPage,
	commerceLayoutsPage,
	commerceMiniCartPage,
	pendingOrdersPage,
}) => {
	await apiHelpers.featureFlag.updateFeatureFlag('COMMERCE-9599', true);

	const site = await apiHelpers.headlessSite.createSite('Edit pending order');

	data.push({id: site.id, type: 'site'});

	const channel = await apiHelpers.headlessCommerceAdminChannel.postChannel({
		name: 'Edit pending order Channel',
		siteGroupId: site.id,
	});

	data.push({id: channel.id, type: 'channel'});

	const catalog = await apiHelpers.headlessCommerceAdminCatalog.postCatalog({
		name: 'Edit pending order Catalog',
	});

	data.push({id: catalog.id, type: 'catalog'});

	const product1 = await apiHelpers.headlessCommerceAdminCatalog.postProduct({
		catalogId: catalog.id,
		name: {en_US: 'Product1'},
	});

	data.push({id: product1.productId, type: 'product'});

	const sku1 = product1.skus[0];

	await Promise.all([
		apiHelpers.headlessCommerceAdminCatalog.postSkuUnitOfMeasure(sku1.id, {
			incrementalOrderQuantity: 3,
			name: {en_US: 'Box'},
			primary: true,
			priority: 1,
			rate: 1,
		}),

		apiHelpers.headlessCommerceAdminCatalog.postSkuUnitOfMeasure(sku1.id, {
			incrementalOrderQuantity: 2,
			name: {en_US: 'Package'},
			priority: 2,
			rate: 0.5,
		}),
	]);

	await applicationsMenuPage.goToSite('Edit pending order');

	await commerceLayoutsPage.goToPages(false);
	await commerceLayoutsPage.createWidgetPage('Pending Orders Page');
	await commerceLayoutsPage.goToPages(false);
	await commerceLayoutsPage.changeCurrentTheme(
		'Select Minium By Liferay, Inc.'
	);
	await commerceLayoutsPage.siteHomePageLink.click();

	await commerceMiniCartPage.quickAddToCart(sku1.sku);

	await pendingOrdersPage.addPendingOrdersWidget();

	await pendingOrdersPage.orderItemActionsButton.click();

	await expect(pendingOrdersPage.orderItemEditActionButton).toBeVisible();

	await apiHelpers.featureFlag.updateFeatureFlag('COMMERCE-9599', false);
});

test('Edit pending order item without UOM', async ({
	apiHelpers,
	applicationsMenuPage,
	commerceLayoutsPage,
	commerceMiniCartPage,
	pendingOrdersPage,
}) => {
	await apiHelpers.featureFlag.updateFeatureFlag('COMMERCE-9599', true);

	const site = await apiHelpers.headlessSite.createSite('Edit pending order');

	data.push({id: site.id, type: 'site'});

	const channel = await apiHelpers.headlessCommerceAdminChannel.postChannel({
		name: 'Edit pending order Channel',
		siteGroupId: site.id,
	});

	data.push({id: channel.id, type: 'channel'});

	const catalog = await apiHelpers.headlessCommerceAdminCatalog.postCatalog({
		name: 'Edit pending order Catalog',
	});

	data.push({id: catalog.id, type: 'catalog'});

	const product1 = await apiHelpers.headlessCommerceAdminCatalog.postProduct({
		catalogId: catalog.id,
		name: {en_US: 'Product1'},
	});

	data.push({id: product1.productId, type: 'product'});

	const product1Skus = await apiHelpers.headlessCommerceAdminCatalog
		.getProduct(product1.productId)
		.then((product) => {
			return product.skus;
		});

	const sku1 = product1Skus[0];

	await applicationsMenuPage.goToSite('Edit pending order');

	await commerceLayoutsPage.goToPages(false);
	await commerceLayoutsPage.createWidgetPage('Pending Orders Page');
	await commerceLayoutsPage.goToPages(false);
	await commerceLayoutsPage.changeCurrentTheme(
		'Select Minium By Liferay, Inc.'
	);
	await commerceLayoutsPage.siteHomePageLink.click();

	await commerceMiniCartPage.quickAddToCart(sku1.sku);

	await pendingOrdersPage.addPendingOrdersWidget();

	await pendingOrdersPage.orderItemActionsButton.click();

	await expect(pendingOrdersPage.orderItemEditActionButton).toHaveCount(0);

	await apiHelpers.featureFlag.updateFeatureFlag('COMMERCE-9599', false);
});
